package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;


/**
 * Controls extending arm position
 */
public class ExtendingArm extends Subsystem {

	static TalonSRX TalonRight = new TalonSRX(RobotMap.ExtendingArmRight);
	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);


	public ExtendingArm()
	{
		super();
	}


	public void initDefaultCommand()
	{
		TalonRight.setInverted(true);
		TalonRight.setSelectedSensorPosition(0);
		TalonLeft.setSelectedSensorPosition(0);
	}


	/**
	* Move Extending Arm Motion
	*/
	public void Move()
	{

		// you probably don't want to go over 0.40
		// Double speed = 0.40;

		// TalonLeft.set(ControlMode.PercentOutput, speed);
		// TalonRight.set(ControlMode.PercentOutput, speed);

		UpdateSmartDashboard();
	}


	/**
	* Stops Extending Arm Motion
	*/
	public void Stop()
	{
		TalonLeft.set(ControlMode.PercentOutput, 0.0);
		TalonRight.set(ControlMode.PercentOutput, 0.0);

		UpdateSmartDashboard();
	}


	/**
	* Go to a specific position
	* @param goToPosition - set talon to certain position
	*/
	public void GoToPosition(int goToPosition)
	{
		// 1670
		// if (TalonLeft.getSelectedSensorPosition() >= goToPosition) {
		// 	// vp.Toggle();
		// 	TalonLeft.set(ControlMode.PercentOutput, 0.0);
		// 	TalonRight.set(ControlMode.PercentOutput, 0.0);
		// }
		TalonLeft.setSelectedSensorPosition(goToPosition);
		TalonRight.setSelectedSensorPosition(goToPosition);
	}

	/**
	* Makes sure the {@link SmartDashboard} is updated with the latest values
	*/
	private void UpdateSmartDashboard() {
		SmartDashboard.putNumber("ExtendingArm/TalonLeft", TalonLeft.getSelectedSensorPosition());
		SmartDashboard.putNumber("ExtendingArm/TalonRight", TalonRight.getSelectedSensorPosition());
	}
}
