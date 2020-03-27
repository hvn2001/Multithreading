package BonusQ.BuildMolecule.F1;

class H2OMachineThread extends Thread {

    H2OMachine molecule;
    String atom;

    public H2OMachineThread(H2OMachine molecule, String atom) {
        this.molecule = molecule;
        this.atom = atom;
    }

    public void run() {
        if ("H".equals(atom)) {
            try {
                molecule.HydrogenAtom();
            } catch (Exception e) {
            }
        } else if ("O".equals(atom)) {
            try {
                molecule.OxygenAtom();
            } catch (Exception e) {
            }
        }
    }
}