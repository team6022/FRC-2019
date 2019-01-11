package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;

public class ExampleCommand extends Command {
	
	public ExampleCommand() 
	{
		requires(Robot.ExampleSubsystem);
	}

	protected void initialize() 
	{
	}

	protected void execute() 
	{
    Robot.ExampleSubsystem.GrabCommand(Robot.OI.getJoystickBran());
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
