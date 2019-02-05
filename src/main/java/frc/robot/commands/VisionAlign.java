package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
* Add description here
*/
public class VisionAlign extends Command
{


	// this is considered the center on the screen
	// these needs to be a double array because there is the possibility of having multiple targets on the screen
	double center[] = {75.0};

	// how far off from the center can the target be in pixels before the robot should stop turning
	double precision = 10.0;

	// how fast you should turn the robot when it is far from the center
	double turnSpeedFar = 0.50;

	// how fast you should turn the robot when it is close to the center
	double turnSpeedClose = 0.25;

	// how many pixels is considered close to the center
	double closeDistance = 38.0;


	NetworkTableInstance inst;
	NetworkTable table;
	double[] centerX;

	public VisionAlign()
	{
		requires(Robot.RhinoTracks);
	}

	protected void initialize()
	{
		// pull data from GRIP report
		inst = NetworkTableInstance.getDefault();
		table = inst.getTable("GRIP/myContoursReport");

		// get the centerX value, if it can't be found, default to 75 (center)
		centerX = table.getEntry("centerX").getDoubleArray(center);
	}

	protected void execute()
	{

		// had to add this try for now because centerx is an array an might not contain any values
		if (centerX.length >= 1) {

			// decide if we need to turn left or right.
			// decrese precision to increase accuracy
			if (centerX[0] < center[0] - precision) {

				if (centerX[0] < center[0] - closeDistance) {
					Robot.RhinoTracks.Turn(-turnSpeedFar);
				} else {
					Robot.RhinoTracks.Turn(-turnSpeedClose);
				}

				if (centerX[0] > center[0] + closeDistance) {
					Robot.RhinoTracks.Turn(turnSpeedFar);
				} else {
					Robot.RhinoTracks.Turn(turnSpeedClose);
				}

			} else if (centerX[0] > center[0] + precision) {

				if (centerX[0] > center[0] + closeDistance) {
					Robot.RhinoTracks.Turn(turnSpeedFar);
				} else {
					Robot.RhinoTracks.Turn(turnSpeedClose);
				}

			} else {
				// ok we found it, stop looking
				Robot.RhinoTracks.Turn(0.00);
			}
		}

	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
	}

	protected void interrupted()
	{
	}

}
