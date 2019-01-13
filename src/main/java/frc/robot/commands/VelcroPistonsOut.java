package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class VelcroPistonsOut extends Command {

	public VelcroPistonsOut()
	{
		requires(Robot.VelcroPistons);
	}

	protected void initialize()
	{
	}

	protected void execute()
	{
		Robot.VelcroPistons.PistonOut(Robot.OI.getJoystickBran());
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
