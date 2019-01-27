package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTrack;
import edu.wpi.first.wpilibj.*;


/**
 * Add description here
 */
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
		Double maxSpeed = 1.0; // percentage

		// check to see if we need to be turning left or right
		if (Branjoy.getY() >= .30 || Branjoy.getY() <= -.30)
		{
			// not turning
			SP1.set((Branjoy.getY() * speed) * maxSpeed);
			SP2.set((Branjoy.getY() * speed) * maxSpeed);
			SP3.set((-Branjoy.getY() * speed) * maxSpeed);
			SP4.set((-Branjoy.getY() * speed) * maxSpeed);
		} else {
			// turning
			SP1.set(Branjoy.getX() * speed);
			SP2.set(Branjoy.getX() * speed);
			SP3.set(Branjoy.getX() * speed);
			SP4.set(Branjoy.getX() * speed);
		}

		SmartDashboard.putNumber("victorSP1", -SP1.get());
		SmartDashboard.putNumber("victorSP2", -SP2.get());
		SmartDashboard.putNumber("victorSP3", SP3.get());
		SmartDashboard.putNumber("victorSP4", SP4.get());
	}
}
