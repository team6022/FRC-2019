package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ExtendingArmMovePosition extends Command
{


	Integer position = 0;

	public ExtendingArmMovePosition(Integer _position)
	{
		requires(Robot.ExtendingArm);
		position = _position;
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.MovePosition(position);
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
