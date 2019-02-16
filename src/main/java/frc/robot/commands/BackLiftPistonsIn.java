package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add description here
 */
public class BackLiftPistonsIn extends Command
{

	public BackLiftPistonsIn()
	{
		requires(Robot.LiftPistons);
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.BackPistonsIn(Robot.OI.getJoystickBran());
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
