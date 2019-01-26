# stuff needed to run this program
# ment to only run when connected to robot
# on the driver station
from collections import deque
from imutils.video import VideoStream
from pathlib import Path
from networktables import NetworkTables
import numpy as np
import threading
import argparse
import cv2
import imutils
import time

NetworkTables.initialize()
sd = NetworkTables.getTable("SmartDashboard")
i = 0


# cap = cv2.VideoCapture(0)
cap = cv2.VideoCapture('http://10.60.22.2:1181/stream.mjpg')
# cap = cv2.VideoCapture('http://lakitu.local:8081')

# tape width = 2in - 50.8mm
# 16in away = 100
# tapewidth = 50.8
distance = 6.25

while(True):


    # Capture frame-by-frame
    ret, frame = cap.read()

    # save orig
    origFrame = frame

    # cv2.imshow("Orignal frame", frame)

    # HSL Adjustment
    frame = cv2.cvtColor(frame, cv2.COLOR_BGR2HLS)
    frame = cv2.inRange(frame, (78, 155, 115), (88, 255, 255))
    # cv2.imshow('hsl', frame)


    # Gaussian Blur
    frame = cv2.GaussianBlur(frame, (13, 13), 0)
    cv2.imshow('blur', frame)


    # Find Cont
    # imgray = cv2.imread(frame, mode="GRAY")
    # ret,thresh = cv2.threshold(imgray, 127, 255, 0)
    # frame, contours= cv2.findContours(thresh, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    ret, thresh = cv2.threshold(frame, 127, 255, 0)
    contours, hierarchy = cv2.findContours(thresh, 1, 2)


    # Get Size
    x, y, w, h = cv2.boundingRect(thresh)
    # print()

    # Draw Contour
    frame = cv2.drawContours(origFrame, contours, -3, (255, 0, 255), 3, 16)

    # add text
    frame = cv2.putText(frame, "Contours: %d" % len(
        contours), (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0, 0, 255), 2)
    # frame = cv2.putText(frame, "distance: %d mm" % (w * distance), (10,60), cv2.FONT_HERSHEY_SIMPLEX, 0.7, (0,0,255), 2)
    sd.putNumber("Contours", len(contours))


    # Display the resulting frame
    cv2.imshow('frame', frame)

    # kill the app with 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# When everything done, release the capture
cap.release()
cv2.destroyAllWindows()
