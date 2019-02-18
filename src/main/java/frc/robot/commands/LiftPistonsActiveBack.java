package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


/**
 * Lift and drops back bottom pistons
 */
public class LiftPistonsActiveBack extends Command
{

	public LiftPistonsActiveBack()
	{
		requires(Robot.LiftPistonsBack);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.LiftPistonsBack.Active(Robot.OI.getJoystickBran());
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
