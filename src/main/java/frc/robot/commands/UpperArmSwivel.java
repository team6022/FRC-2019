package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class UpperArmSwivel extends Command
{

	public UpperArmSwivel()
	{
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.MoveUpperArm(Robot.OI.getJoystickBran());
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
