package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ExtendingArmMove extends Command
{

	public ExtendingArmMove()
	{
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.JoystickMove(Robot.OI.getJoystickBran());
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
