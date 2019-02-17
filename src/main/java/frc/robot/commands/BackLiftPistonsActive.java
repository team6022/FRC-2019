package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Add description here
 */
public class BackLiftPistonsActive extends Command
{

	Boolean _isActive = false;

	public BackLiftPistonsActive(Boolean isActive)
	{
		requires(Robot.LiftPistons);
		_isActive = isActive;
	}

	protected void initialize()
	{

	}

	protected void execute()
	{
		Robot.LiftPistons.BackPistonsActive(_isActive);
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
