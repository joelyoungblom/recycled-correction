package recycledcorrection;

public class RecycleCorrector {
    public RecycleCorrector() {
        clearAndReset();
    }
    
    public void calculate() {
        double uwNat = 62.4*specificGravityOfNaturalGravel;
        double uwRec = 62.4*specificGravityOfRecycledGravel;
        double dNat = percentNaturalGravelOfTest-percentNaturalGravelOfProctor;
        double dRec = percentRecycledGravelOfTest-percentRecycledGravelOfProctor;
        
        double natPart = ( (1-percentRecycledGravelOfProctor/100)*dryDensityOfTest*uwNat*(100-dNat)) / (100*uwNat-dryDensityOfTest*dNat);
        double recPart = ( (percentRecycledGravelOfProctor/100)*dryDensityOfTest*uwRec*(100-dRec)) / (100*uwRec-dryDensityOfTest*dRec);
        
        correctedDensity = natPart + recPart;
        percentCompaction = correctedDensity / dryDensityOfProctor * 100;
    }
    
    public void clearAndReset() {
        numberOfTest = null;
        dryDensityOfTest = 0.0;
        percentNaturalGravelOfTest = 0.0;
        percentRecycledGravelOfTest = 0.0;
        
        numberOfProctor = null;
        dryDensityOfProctor = 0.0;
        percentNaturalGravelOfProctor = 0.0;
        percentRecycledGravelOfProctor = 0.0;
        
        specificGravityOfNaturalGravel = DEFAULT_NATURAL_SPECIFIC_GRAVITY;
        specificGravityOfRecycledGravel = DEFAULT_RECYCLED_SPECIFIC_GRAVITY;
        
        correctedDensity = 0.0;
        percentCompaction = 0.0;
    }
    
    // getters and setters
    
    public String getNumberOfTest() { return numberOfTest; }
    public void setNumberOfTest(String numberOfTest) { this.numberOfTest = numberOfTest; }
    public double getDryDensityOfTest() { return dryDensityOfTest; }
    public void setDryDensityOfTest(double dryDensityOfTest) { this.dryDensityOfTest = dryDensityOfTest; }
    public double getPercentNaturalGravelOfTest() { return percentNaturalGravelOfTest; }
    public void setPercentNaturalGravelOfTest(double percentNaturalGravelOfTest) { this.percentNaturalGravelOfTest = percentNaturalGravelOfTest; }
    public double getPercentRecycledGravelOfTest() { return percentRecycledGravelOfTest; }
    public void setPercentRecycledGravelOfTest(double percentRecycledGravelOfTest) { this.percentRecycledGravelOfTest = percentRecycledGravelOfTest; }

    public String getNumberOfProctor() { return numberOfProctor; }
    public void setNumberOfProctor(String numberOfProctor) { this.numberOfProctor = numberOfProctor; }
    public double getDryDensityOfProctor() { return dryDensityOfProctor; }
    public void setDryDensityOfProctor(double dryDensityOfProctor) { this.dryDensityOfProctor = dryDensityOfProctor; }
    public double getPercentNaturalGravelOfProctor() { return percentNaturalGravelOfProctor; }
    public void setPercentNaturalGravelOfProctor(double percentNaturalGravelOfProctor) { this.percentNaturalGravelOfProctor = percentNaturalGravelOfProctor; }
    public double getPercentRecycledGravelOfProctor() { return percentRecycledGravelOfProctor; }
    public void setPercentRecycledGravelOfProctor(double percentRecycledGravelOfProctor) { this.percentRecycledGravelOfProctor = percentRecycledGravelOfProctor; }

    public double getSpecificGravityOfNaturalGravel() { return specificGravityOfNaturalGravel; }
    public void setSpecificGravityOfNaturalGravel(double specificGravityOfNaturalGravel) { this.specificGravityOfNaturalGravel = specificGravityOfNaturalGravel; }
    public double getSpecificGravityOfRecycledGravel() { return specificGravityOfRecycledGravel; }
    public void setSpecificGravityOfRecycledGravel(double specificGravityOfRecycledGravel) { this.specificGravityOfRecycledGravel = specificGravityOfRecycledGravel; }
    
    public double getCorrectedDensity() { return correctedDensity; }
    public double getPercentCompaction() { return percentCompaction; }

    public double getDefaultNaturalSpecificGravity() { return DEFAULT_NATURAL_SPECIFIC_GRAVITY; }
    public double getDefaultRecycledSpecificGravity() { return DEFAULT_RECYCLED_SPECIFIC_GRAVITY; }

    // variables
    
    private static final double DEFAULT_NATURAL_SPECIFIC_GRAVITY = 2.70;
    private static final double DEFAULT_RECYCLED_SPECIFIC_GRAVITY = 2.30;
    
    private String numberOfTest;
    private double dryDensityOfTest;
    private double percentNaturalGravelOfTest;
    private double percentRecycledGravelOfTest;
    
    private String numberOfProctor;
    private double dryDensityOfProctor;
    private double percentNaturalGravelOfProctor;
    private double percentRecycledGravelOfProctor;
    
    private double specificGravityOfNaturalGravel;
    private double specificGravityOfRecycledGravel;
    
    private double correctedDensity;
    private double percentCompaction;
    
}
