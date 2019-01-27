package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveTrack extends Command
/**
 * Add description here
 */
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
		Robot.RhinoTracks.Drive(Robot.OI.getJoystickBran());
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
