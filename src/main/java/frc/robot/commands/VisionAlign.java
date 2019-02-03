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
	double center[] = {75.0};

	// how far off from the center can the target be in pixels before the robot should stop turning
	double precision = 20.0;

	// how quickly should the robot turn to find the target
	double turnSpeed = 0.20;


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


		try {

			System.out.println(centerX[0]);

			// decide if we need to turn left or right.
			// decrese precision to increase accuracy
			if (centerX[0] < center[0] - precision) {
				Robot.RhinoTracks.Turn(-turnSpeed);
			} else if (centerX[0] > center[0] + precision) {
				Robot.RhinoTracks.Turn(turnSpeed);
			}
		} catch (Exception e) {
			//TODO: handle exception
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
