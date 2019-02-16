package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 * Add description here
 */
public class ExtendingArm extends Subsystem {

	static Talon LowerArmLeft = new Talon(RobotMap.LowerArmLeft);
	static Talon LowerArmRight = new Talon(RobotMap.LowerArmRight);
	static Talon UpperArm = new Talon(RobotMap.UpperArm);

	static Encoder LowerEncoderL =  new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	static Encoder LowerEncoderR =  new Encoder(2, 3, false, Encoder.EncodingType.k4X);

	public ExtendingArm()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void MoveLowerArm(Joystick Branjoy)
	{

		Double speed = 0.40; // you probably don't want to go over 0.40

		LowerEncoderL.reset();
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println("---Before Reset---");
		LowerArmLeft.set(speed);
		LowerArmRight.set(-speed);
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println(LowerEncoderL.get());
		System.out.println("---After Reset---");
	}

	public void MoveUpperArm(Joystick Branjoy)
	{
		UpperArm.set(0.25);
	}

	public void IntakeBall(Joystick Branjoy, Boolean isForward)
	{
		double speed = 0.25;
		int direction = -1;
		if (isForward) direction = 1;

		UpperArm.set(speed * direction);
	}
}
