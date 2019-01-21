package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

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
}
