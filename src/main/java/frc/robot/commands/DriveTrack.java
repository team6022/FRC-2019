package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Drives Robot
 */
public class DriveTrack extends Command
{

	public DriveTrack()
	{
		requires(Robot.RhinoTracks);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.RhinoTracks.DriveJoystick(Robot.OI.getJoystickBran());
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
