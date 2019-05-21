/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytrees;

import java.util.*;

/**
 *
 * @author admin
 */
public class FamilyTrees {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<10;i++){
            try {
                dotestCase();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private static void dotestCase() {
        int total = 1;
        HashSet<String> peo = new HashSet<String>();
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            String lp = in.nextLine();
            
            String[] parts=lp.split("\\.");
            String prefix="";
            
            for (int j=0;j<parts.length;j++) {
                String current=parts[j];
                HashSet<String> nodes=getPossibleNodes(prefix,current);
                peo.addAll(nodes);
                prefix+=current+".";
                
            }
          
            /*if(!peo.contains(lp))
                peo.add(lp);
            
            
            String[] p = lp.split("\\.");
            int q = 0;
            for(int j = lp.length()-1;j>=0;j-=(1+p[p.length-q-1].length())){
                for(int k=Integer.parseInt(lp.substring(j,j+p[p.length-q-1].length()));k>=1;k--){
                    String a = lp.substring(0,j);
                    a = a+k;
                    if(!peo.contains(a))
                        peo.add(a);
                }
                q++;
                if(q==p.length)break;
            }*/
        }
        if(peo.contains("0"))
            peo.remove("0");
        total+=peo.size();
        System.out.println(total);
    }

    private static HashSet<String> getPossibleNodes(String prefix, String current) {
        HashSet<String> hashSet=new HashSet();
        int intCurrent=Integer.parseInt(current);
        for (int i=1;i<=intCurrent;i++) {
            String node=prefix+i;
            hashSet.add(node);
        }
        return hashSet;
    }
    
}