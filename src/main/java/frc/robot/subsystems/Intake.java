package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.*;


/**
 * Add description here
 */
public class Intake extends Subsystem {


	static Talon Intake = new Talon(RobotMap.Intake);


	public Intake()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}


	public void IntakeBall(Joystick Branjoy, Double speed)
	{
		Intake.set(speed);
	}

}
