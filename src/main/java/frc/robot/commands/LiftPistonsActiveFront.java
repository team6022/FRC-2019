package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Lift and drops front bottom pistons
 */
public class LiftPistonsActiveFront extends Command
{

	Boolean _isActive = false;

	public LiftPistonsActiveFront(Boolean isActive)
	{
		requires(Robot.LiftPistons);
		_isActive = isActive;
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.FrontActive(_isActive);
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
