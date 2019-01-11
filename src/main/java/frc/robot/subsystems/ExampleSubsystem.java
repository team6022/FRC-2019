package frc.robot.subsystems;

import frc.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

public class ExampleSubsystem extends Subsystem {
	
	static VictorSP SP1 = new VictorSP(0);
	static VictorSP SP2 = new VictorSP(1);
	static VictorSP SP3 = new VictorSP(2);
  static VictorSP SP4 = new VictorSP(3);
  static DoubleSolenoid exampleDouble = new DoubleSolenoid(0, 1);
	
	public double ExpotentialY;
	public double ExpotentialX = 1;

	public ExampleSubsystem() 
	{
		super();
	}

    public void initDefaultCommand() 
    {

    }
  
	public void GrabCommand(Joystick Branjoy) 
	{
    exampleDouble.set(DoubleSolenoid.Value.kForward);
  }
}
