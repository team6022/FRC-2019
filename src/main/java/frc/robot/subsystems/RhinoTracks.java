package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTrack;
import edu.wpi.first.wpilibj.*;


public class RhinoTracks extends Subsystem {

	static VictorSP SP1 = new VictorSP(RobotMap.SP1Channel);
	static VictorSP SP2 = new VictorSP(RobotMap.SP2Channel);
	static VictorSP SP3 = new VictorSP(RobotMap.SP3Channel);
	static VictorSP SP4 = new VictorSP(RobotMap.SP4Channel);

	public RhinoTracks()
	{
		super();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveTrack());
	}

	public void Drive(Joystick Branjoy)
	{
		Double speed = 1.0;

		if (Branjoy.getY() >= .15 || Branjoy.getY() <= -.15)
		{
			SP1.set(-Branjoy.getY() * speed);
			SP2.set(-Branjoy.getY() * speed);
			SP3.set(Branjoy.getY() * speed);
			SP4.set(Branjoy.getY() * speed);
		} else {

			SP1.set(Branjoy.getX() * speed);
			SP2.set(Branjoy.getX() * speed);
			SP3.set(Branjoy.getX() * speed);
			SP4.set(Branjoy.getX() * speed);
		}

		SmartDashboard.putNumber("victorSP1", SP1.get());
		SmartDashboard.putNumber("victorSP2", SP2.get());
		SmartDashboard.putNumber("victorSP3", -SP3.get());
		SmartDashboard.putNumber("victorSP4", -SP4.get());
	}
}