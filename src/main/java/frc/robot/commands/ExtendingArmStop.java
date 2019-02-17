package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ExtendingArmStop extends Command
{

	public ExtendingArmStop()
	{
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.Stop();
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