package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


/**
 * Lift and drops back bottom pistons
 */
public class LiftPistonsBackActive extends Command
{

	Boolean _isActive = false;

	public LiftPistonsBackActive(Boolean isActive)
	{
		_isActive = isActive;
		requires(Robot.LiftPistons);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.LiftPistons.BackActive(_isActive);
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
