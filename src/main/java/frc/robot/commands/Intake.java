package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Intake extends Command
{

	Double _Speed = 0.0;

	public Intake(Double Speed)
	{
		_Speed = Speed;
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.Intake.IntakeBall(Robot.OI.getJoystickBran(), _Speed);
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