package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add description here
 */
public class FrontLiftPistonsOut extends Command
{

	public FrontLiftPistonsOut()
	{
		requires(Robot.LiftPistons);
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.FrontPistonsOut(Robot.OI.getJoystickBran());
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
