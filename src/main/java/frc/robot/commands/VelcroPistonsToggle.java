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
	}

	protected void execute()
	{
		Robot.VelcroPistons.Toggle();
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
