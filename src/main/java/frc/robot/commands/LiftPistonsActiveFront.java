package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Lift and drops front bottom pistons
 */
public class LiftPistonsActiveFront extends Command
{

	public LiftPistonsActiveFront()
	{
		requires(Robot.LiftPistonsFront);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.LiftPistonsFront.Active(Robot.OI.getJoystickBran());
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
