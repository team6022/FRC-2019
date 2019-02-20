package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.commands.ExtendingArmMove;
import frc.robot.RobotMap;
import frc.robot.Robot;


/**
 * Controls extending arm position
 */
public class ExtendingArm extends Subsystem {

	static TalonSRX TalonRight = new TalonSRX(RobotMap.ExtendingArmRight);
	static TalonSRX TalonLeft = new TalonSRX(RobotMap.ExtendingArmLeft);
	public Integer X = 0;

	public Integer[] cargoHole = {940, 1886, 2973};
	public Integer[] hatchHole = {600, 1570, 2682};

	public ExtendingArm()
	{
		super();
	}


	public void initDefaultCommand()
	{

		setDefaultCommand(new ExtendingArmMove());

		TalonLeft.setInverted(true);
		TalonRight.setSelectedSensorPosition(0);
		TalonLeft.setSelectedSensorPosition(0);
	}


	/**
	* Move Extending Arm Motion
	*/
	public void Move(XboxController Branjoy)
	{

		// you probably don't want to go over 0.40
		Double speed = 0.40;

		switch(X) {
			case 1:
				if (TalonLeft.getSelectedSensorPosition() <= 940)
				{

					TalonLeft.set(ControlMode.PercentOutput, speed);
					TalonRight.set(ControlMode.PercentOutput, speed);

					UpdateSmartDashboard();
				}
				Robot.ExtendingArm.Stop();
				X++;
				break;
			case 2:
				if (X == 1 && TalonLeft.getSelectedSensorPosition() <= 1886)
				{
					TalonLeft.set(ControlMode.PercentOutput, speed);
					TalonRight.set(ControlMode.PercentOutput, speed);

					UpdateSmartDashboard();
				}
				Robot.ExtendingArm.Stop();
				X++;
				break;
			default:
				if (X == 2 && TalonLeft.getSelectedSensorPosition() <= 2973)
				{

					TalonLeft.set(ControlMode.PercentOutput, speed);
					TalonRight.set(ControlMode.PercentOutput, speed);

					UpdateSmartDashboard();
				}
				Robot.ExtendingArm.Stop();
				X = 0;
				break;
		}
	}



	/**
	* Optional Move function to try that Matt wrote
	*/
	public void MoveToHatchHole(XboxController Branjoy)
	{

		// you probably don't want to go over 0.40
		Double speed = 0.40;

		Integer povdirection = Branjoy.getPOV();
		Integer talonPosition = TalonLeft.getSelectedSensorPosition();

		switch (povdirection)
		{
			case 0:
				X++;
				if (X > hatchHole.length -1) X = 0;
				break;
			case 180:
				X--;
				if (X < 0) X = hatchHole.length;
				break;
		}


		if (talonPosition <= hatchHole[X]) {
			while (talonPosition <= hatchHole[X]) {
				TalonLeft.set(ControlMode.PercentOutput, speed);
				TalonRight.set(ControlMode.PercentOutput, speed);
			}
			Robot.ExtendingArm.Stop();
		} else if (talonPosition > hatchHole[X]) {
			while (talonPosition > hatchHole[X]) {
				TalonLeft.set(ControlMode.PercentOutput, -speed);
				TalonRight.set(ControlMode.PercentOutput, -speed);
			}
			Robot.ExtendingArm.Stop();
		}

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
	* Makes sure the {@link SmartDashboard} is updated with the latest values
	*/
	private void UpdateSmartDashboard() {
		SmartDashboard.putNumber("ExtendingArm/TalonLeft", TalonLeft.getSelectedSensorPosition());
		SmartDashboard.putNumber("ExtendingArm/TalonRight", TalonRight.getSelectedSensorPosition());
	}
}
