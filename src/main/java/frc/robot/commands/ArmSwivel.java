package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ArmSwivel extends Command
{

	public ArmSwivel()
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
