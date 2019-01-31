package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerArmSwivel extends Command
{

	public LowerArmSwivel()
	{
		requires(Robot.RhinoTracks);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.ExtendingArm.MoveLowerArm(Robot.OI.getJoystickBran());
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
