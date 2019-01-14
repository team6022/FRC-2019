package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VelcroPistonsIn extends Command
{

	public VelcroPistonsIn()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.VelcroPistons.PistonIn(Robot.OI.getJoystickBran());
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
