package frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import com.revrobotics.*;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;

// Create the shooter subsystem
public class ShooterSubsystem extends SubsystemBase {
    // Define the shooterMotor from CANSparkMax
    private final CANSparkMax shooterMotor;

    // Start to define the motor settings
    public ShooterSubsystem() {
        // Set it to CAN ID 16
        shooterMotor = new CANSparkMax(16, MotorType.kBrushless);
        // Restore defaults
        shooterMotor.restoreFactoryDefaults();
        // Set the motor to break
        shooterMotor.setIdleMode(IdleMode.kBrake);
    }

    // Create the runShooter Command
    // Take the double speed as the input
    // Set the motor to speed
    public Command runShooter(double speed){
        return run(() ->
            shooterMotor.set(speed)
        );
    }

    // Create the stopShooter Command
    // Sets the shooter motor to 0
    public Command stopShooter(){
        return this.run(() -> 
            shooterMotor.set(0)
        );
    }
    public Command autoShooterRun(){
        return this.run(() -> 
            shooterMotor.set(1)
        );
    }
}
