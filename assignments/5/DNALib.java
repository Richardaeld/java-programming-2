public class DNALib {
    boolean validateBases (String dna) {
        if (dna.length() == 0) return true;
        switch (dna.substring(0,1)) {
            case "A":
            case "C":
            case "G":
            case "T": break;
            default : return false;
        }
        return validateBases(dna.substring(1));
    }

    String translate (String dna) {
        switch (dna) {
            case "AAA": return "K";
            case "ACA": return "T";
            case "AGA": return "R";
            case "ATA": return "I";
            case "CAA": return "Q";
            case "CCA": return "P";
            case "CGA": return "R";
            case "CTA": return "L";
            case "GAA": return "E";
            case "GCA": return "A";
            case "GGA": return "G";
            case "GTA": return "V";
            case "TAA": return "-";
            case "TCA": return "S";
            case "TGA": return "-";
            case "TTA": return "L";
            case "AAC": return "N";
            case "ACC": return "T";
            case "AGC": return "S";
            case "ATC": return "I";
            case "CAC": return "H";
            case "CCC": return "P";
            case "CGC": return "R";
            case "CTC": return "L";
            case "GAC": return "D";
            case "GCC": return "A";
            case "GGC": return "G";
            case "GTC": return "V";
            case "TAC": return "Y";
            case "TCC": return "S";
            case "TGC": return "C";
            case "TTC": return "F";
            case "AAG": return "K";
            case "ACG": return "T";
            case "AGG": return "R";
            case "ATG": return "M";
            case "CAG": return "Q";
            case "CCG": return "P";
            case "CGG": return "R";
            case "CTG": return "L";
            case "GAG": return "E";
            case "GCG": return "A";
            case "GGG": return "G";
            case "GTG": return "V";
            case "TAG": return "-";
            case "TCG": return "S";
            case "TGG": return "W";
            case "TTG": return "L";
            case "AAT": return "N";
            case "ACT": return "T";
            case "AGT": return "S";
            case "ATT": return "I";
            case "CAT": return "H";
            case "CCT": return "P";
            case "CGT": return "R";
            case "CTT": return "L";
            case "GAT": return "D";
            case "GCT": return "A";
            case "GGT": return "G";
            case "GTT": return "V";
            case "TAT": return "Y";
            case "TCT": return "S";
            case "TGT": return "C";
            case "TTT": return "F";
            default:    return "";
        }
    }

    boolean validator (String dna) {
        if (dna.length() == 0)     return false;
        if (dna.length() % 3 != 0) return false;
        if(!validateBases(dna))    return false;

        return true;
    }
    String reverser (String dna) {
        if (dna.length() == 0) return dna;
        return reverser(dna.substring(1)) + dna.charAt(0);
    }
    String inverser (String dna) {
        if (dna.length() == 0) return dna;
        String flipChar = "";
        switch (dna.charAt(dna.length()-1)) {
            case 'A': flipChar = "T"; break;
            case 'C': flipChar = "G"; break;
            case 'G': flipChar = "C"; break;
            case 'T': flipChar = "A"; break;
        }
        return inverser(dna.substring(0,dna.length()-1)) + flipChar;
    }


    String translator (String dna) {
        if (dna.length() == 0) return dna;
        String translated = translate(dna.substring(dna.length()-3));
        return translator(dna.substring(0, dna.length()-3)) + translated;
    }
}
