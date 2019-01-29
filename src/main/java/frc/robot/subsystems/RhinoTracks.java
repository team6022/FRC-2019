package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTrack;


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
		Double speedDrive = 1.0;
		Double speedTurn = 1.0;

		// check to see if we need to be turning left or right
		if (Branjoy.getY() >= .30 || Branjoy.getY() <= -.30)
		{
			// driving
			SP1.set(Branjoy.getY() * speedDrive);
			SP2.set(Branjoy.getY() * speedDrive);
			SP3.set(-Branjoy.getY() * speedDrive);
			SP4.set(-Branjoy.getY() * speedDrive);
		} else {
			// turning
			SP1.set(Branjoy.getX() * speedTurn);
			SP2.set(Branjoy.getX() * speedTurn);
			SP3.set(Branjoy.getX() * speedTurn);
			SP4.set(Branjoy.getX() * speedTurn);
		}

		SmartDashboard.putNumber("victorSP1", -SP1.get());
		SmartDashboard.putNumber("victorSP2", -SP2.get());
		SmartDashboard.putNumber("victorSP3", SP3.get());
		SmartDashboard.putNumber("victorSP4", SP4.get());
	}
}
