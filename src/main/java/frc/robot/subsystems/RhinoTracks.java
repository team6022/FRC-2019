package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveTrack;
import edu.wpi.first.wpilibj.*;


public class RhinoTracks extends Subsystem {

    static VictorSP SP1 = new VictorSP(0);
	static VictorSP SP2 = new VictorSP(1);
	static VictorSP SP3 = new VictorSP(2);
	static VictorSP SP4 = new VictorSP(3);

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
        if (Branjoy.getY() >= .15 || Branjoy.getY() <= -.15)
		{
			
			SP1.set(-Branjoy.getY()*0.60);
			SP2.set(-Branjoy.getY()*0.60);
			SP3.set(Branjoy.getY()*0.60);
            SP4.set(Branjoy.getY()*0.60);
            
            SmartDashboard.putNumber("getY", -Branjoy.getY()*0.60);


		}
		
		else
		{			
			SP1.set(Branjoy.getX()*0.50);
			SP2.set(Branjoy.getX()*0.50);
			SP3.set(Branjoy.getX()*0.50);
            SP4.set(Branjoy.getX()*0.50);
            
            SmartDashboard.putNumber("getX", -Branjoy.getX()*0.50);


		}
	}
}