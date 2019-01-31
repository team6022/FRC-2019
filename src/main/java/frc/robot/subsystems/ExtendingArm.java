package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 * Add description here
 */
public class ExtendingArm extends Subsystem {

	static VictorSP LowerArm = new VictorSP(RobotMap.LowerArm);
	static VictorSP UpperArm = new VictorSP(RobotMap.UpperArm);

	public ExtendingArm()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void MoveLowerArm(Joystick Branjoy)
	{
		LowerArm.set(0.5);
	}

	public void MoveUpperArm(Joystick Branjoy)
	{
		UpperArm.set(0.5);
	}
}
