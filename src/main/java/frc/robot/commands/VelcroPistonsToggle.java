package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


/**
 * Toggles the front velcro pistons
 */
public class VelcroPistonsToggle extends Command
{

	public VelcroPistonsToggle()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{
		// set a 1 second timeout
		setTimeout(1);
	}

	protected void execute()
	{
		// Robot.VelcroPistons.Toggle();
		Robot.VelcroPistons.Active(true);
	}

	protected boolean isFinished()
	{
		// return true;
		return isTimedOut();
	}

	protected void end()
	{
		Robot.VelcroPistons.Active(false);
	}

	protected void interrupted()
	{
	}

}
