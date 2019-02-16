package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeRun extends Command
{

	Boolean _isForward = false;
	Double _Speed = 0.0;


	public IntakeRun(Double Speed)
	{
		_Speed = Speed;
		requires(Robot.ExtendingArm);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.IntakeBall(Robot.OI.getJoystickBran(), _Speed);
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