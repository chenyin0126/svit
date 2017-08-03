/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rex_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chenyinliu
 */
public class Rex_test {

    public static void main(String args[]) {
        String str = "IVS11+6G>A";
        
//        String str1= "G142_A173delins";
        

//        System.out.println(test(str1));
        //System.out.println("123".matches("(\\d{3}[.-]?){2}\\d{4}"));
        if (genericKeyWord1(str) || genericKeyWord2(str) || genericKeyWord3(str)
                ||genome_Range_1(str)|| cDNA_Inst_Rge(str) || cDNA_IVS(str) 
                || genome_Subs(str) || genome_Chr_1(str)||cDNA_keyWord(str)
                || genome_Chr_2(str) || cDNA_Subs_1(str) || cDNA_Subs_Rge(str)
                || cDNA_keyWord_1(str) || cDNA_keyWord_2(str)
                || cDNASeq_4(str) || RNA_Subs(str) || RNA_Range_1(str) || RNA_Range_2(str)
                ||protein_Seq1(str)||protein_Seq2(str)||protein_FS(str)||protein_SeqNum(str)
                ||protein_Range_1(str)||protein_Range_1a(str)||protein_Range_2(str)   ) {
            //nothing here 
        } else {
            System.out.println("Error :" + str);
        }
    }

    public static boolean capNuleo(String str) {
        Pattern pat = Pattern.compile("A|G|C|T");
        Matcher m = pat.matcher(str);
        return m.matches();
    }

    public static boolean lowNucleo(String str) {
        Pattern pat = Pattern.compile("a|g|c|u");
        Matcher m = pat.matcher(str);
        return m.matches();
    }

    public static boolean amino1Code(String str) {
        Pattern pat = Pattern.compile("A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\. ");
        Matcher m = pat.matcher(str);
        return m.matches();
    }

    public static boolean amino3Code(String str) {
        Pattern pat = Pattern.compile("Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr");
        Matcher m = pat.matcher(str);
        return m.matches();
    }

    public static boolean aminoCode(String str) {
        Pattern pat = Pattern.compile("{amino1Code}|{amino3Code}");
        Matcher m = pat.matcher(str);
        return m.matches();
    }

    public static boolean genericKeyWord1(String str) {
        Pattern pat = Pattern.compile("amp|ampl|amplification|gain|loss|dup|dupl|duplication|del|deletion|inv|inversion");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("Generic         : " + str);
        }
        return m.matches();
    }

    public static boolean genericKeyWord2(String str) {
        Pattern pat = Pattern.compile("insertion|positive|negative|pos|neg|\\+|\\-|high|low|hi|lo|intermediate|medium|stable|unstable|instable|\"unstable high\"|\"unstable low\"");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("Generic         : " + str);
        }
        return m.matches();
    }

    public static boolean genericKeyWord3(String str) {
        Pattern pat = Pattern.compile("moderate|present|absent|undertermined|underter|mutated|rearrangement|fusion|translocation|\"not significant\"F");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("Generic         : " + str);
        }
        return m.matches();
    }

    public static boolean genome_Subs(String str) {
        Pattern pat = Pattern.compile("(g.)?(([0-9]+)|(([0-9]+)(([+-])([0-9]+))?(_)([0-9]+)(([+-])([0-9]+))?))([AGCT]+)(>)([AGCT]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("genome_Subs          : " + str);
        }
        return m.matches();
    }

    public static boolean genome_Range_1(String str) {
        Pattern pat = Pattern.compile("");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("genome_Range_1          : " + str);
        }
        return m.matches();
    }

    public static boolean genome_Chr_1(String str) {
        Pattern pat = Pattern.compile("(chr)(([1-9]|1[0-9]|2[0-2])|[XY])(:)(g.)?([0-9]+)([AGCT]+)(>)[AGCT]+");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("genome_Chr_1          : " + str);
        }
        return m.matches();
    }

    public static boolean genome_Chr_2(String str) {
        Pattern pat = Pattern.compile("(chr)(([1-9]|1[0-9]|2[0-2])|[XY])(:)((([0-9]+)|(([0-9]+)?([+-])([0-9]+)))|(((([0-9]+)|(([0-9]+)?([+|-])([0-9]+))))(_)(([0-9]+)|(([0-9]+)?([+|-])([0-9]+)))))(ins|del|delins|dup|dupl|inv)(([AGCT]+)|([0-9]+))");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("genome_Chr_2          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_Subs_1(String str) {

        Pattern pat = Pattern.compile("(c.)?(-|\\*)?(([0-9]+)|(([0-9]+)?([+-])([0-9]+)))([AGCT]+)(>)([AGCT]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_Subs_1          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_Subs_Rge(String str) {

        Pattern pat = Pattern.compile("(c.)?((([0-9]+)|(([0-9]+)?([+-])([0-9]+)))|(((([0-9]+)|(([0-9]+)?([+|-])([0-9]+))))(_)(([0-9]+)|(([0-9]+)?([+|-])([0-9]+)))))([AGCT]+)(>)([AGCT]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_Subs_Rge          : " + str);
        }
        return m.matches();

    }

    public static boolean cDNA_Inst_Rge(String str) {
        Pattern pat = Pattern.compile("(c.)?((([0-9]+)|(([0-9]+)?([+-])([0-9]+)))|(((([0-9]+)|(([0-9]+)?([+|-])([0-9]+))))(_)(([0-9]+)|(([0-9]+)?([+|-])([0-9]+)))))(ins|del|delins|dup|dupl|inv)(([AGCT]+)|([0-9]+))?");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_Inst_Rge          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_IVS(String str) {
        Pattern pat = Pattern.compile("(c.)?(IVS)([0-9]+)-([0-9]+)([A|G|C|T]+)(>)([A|G|C|T]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_IVS          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_keyWord(String str) {
        Pattern pat = Pattern.compile("promoter|splice|splicing|\"splicing site\"|\"splice site\"");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_keyWord          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_keyWord_1(String str) {
        Pattern pat = Pattern.compile("(promoter|splice|splicing|\"splicing site\"|\"splice site\")(\\s)(c.)?((-?([0-9]+))(_)(-?([0-9]+)))");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_keyWord_1          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNA_keyWord_2(String str) {
        Pattern pat = Pattern.compile("(promoter|splice|splicing|\"splicing site\")(\\s)(c.)?(((\\+|-)?([0-9]+))(_)((\\+|-)?([0-9]+)))([AGCT]+)(>)([AGCT]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNA_keyWord_2          : " + str);
        }
        return m.matches();
    }

    public static boolean cDNASeq_4(String str) {
        Pattern pat = Pattern.compile("(promoter|splice|splicing|splicing site|splice site)(\\s)(c.)?-?([0-9]+)(-)([0-9]+)([AGCT]+)(>)([AGCT]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("cDNASeq_4          : " + str);
        }
        return m.matches();
    }

    public static boolean RNA_Subs(String str) {
        Pattern pat = Pattern.compile("(r.)?(-?([0-9]+))([agcu]+)(>)([agcu]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("RNA_Subs          : " + str);
        }
        return m.matches();
    }

    public static boolean RNA_Range_1(String str) {
        Pattern pat = Pattern.compile("(r.)?(([0-9]+)|(([0-9]+)(([+-])([0-9]+))?(_)([0-9]+)(([+-])([0-9]+))?))(ins|del|delins|dup|dupl|inv)([agcu]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("RNA_Range_1          : " + str);
        }
        return m.matches();
    }

    public static boolean RNA_Range_2(String str) {
        Pattern pat = Pattern.compile("(r.)?(([0-9]+)|(([0-9]+)(([+-])([0-9]+))?(_)([0-9]+)(([+-])([0-9]+))?))(ins|del|delins|dup|dupl|inv)([0-9]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("RNA_Range_2          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_Seq1(String str) {
        Pattern pat = Pattern.compile("(p.)?((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))([0-9]+)(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))|(=))");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_Seq1          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_Seq2(String str) {
        Pattern pat = Pattern.compile("(p.)?((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))"
                + "([0-9]+)(ins|del|delins|dup|dupl|inv)"
                + "(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))+)?");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_Seq2          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_FS(String str) {
        Pattern pat = Pattern.compile("(p.)?((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))([0-9]+)((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))?([(fs)|(\\*)]+)([0-9]+)?");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_FS          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_SeqNum(String str) {
        Pattern pat = Pattern.compile("(p.)?((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))([0-9]+)(ins|del|delins|dup|dupl|inv)([0-9]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_SeqNum          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_Range_1(String str) {
        Pattern pat = Pattern.compile("(p.)?(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr)"
                + ")([0-9]+)(_)((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))"
                + "([0-9]+)(ins|del|delins|dup|dupl|inv)+"
                + "(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))+)?"
                + ")");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_Range_1          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_Range_1a(String str) {
        Pattern pat = Pattern.compile("(p.)?(([0-9]+)(([+-])([0-9]+))?(_)([0-9]+)(([+-])([0-9]+))?)(ins|del|delins|dup|dupl|inv)(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_Range_1a          : " + str);
        }
        return m.matches();
    }

    public static boolean protein_Range_2(String str) {
        Pattern pat = Pattern.compile("(p.)?(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))([0-9]+)(_)((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))([0-9]+))(ins|del|delins|dup|dupl|inv)([0-9]+)");
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("protein_Range_2          : " + str);
        }
        return m.matches();
    }
    
    public static boolean test(String str) {
        Pattern pat = Pattern.compile("(p.)?(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr)"
                + ")([0-9]+)(_)((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))"
                + "([0-9]+)(ins|del|delins|dup|dupl|inv)+"
                + "(((A|C|D|E|F|G|H|I|K|L|M|N|P|Q|R|S|T|V|W|Y|\\*|\\.)"
                + "|(Ala|Cys|Asp|Glu|Phe|Gly|His|Ile|Lys|Leu|Met|Asn|Pro|Gln|Arg|Ser|Thr|Val|Trp|Tyr))+)?"
                + ")");
        
        Matcher m = pat.matcher(str);
        if (m.matches()) {
            System.out.println("test          : " + str);
        }
        return m.matches();
    }
    
    
    

}
