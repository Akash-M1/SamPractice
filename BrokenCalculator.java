import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrokenCalculator {
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int o = sc.nextInt();
            ArrayList<Integer> worknumbers = new ArrayList<>();
            for(int i=0;i<n;i++){
                worknumbers.add(sc.nextInt());
            }
            int[] operations = new int[4];
            for(int i=0;i<m;i++){
                operations[sc.nextInt()-1] = 1;
            }
            int target = sc.nextInt();
            HashMap<Integer,Integer> out = new HashMap<>();
            getMinOperations(target, out, 1, worknumbers, o, operations);
            System.out.println("#"+test_case+" "+ans);
            ans = Integer.MAX_VALUE;
        }
        sc.close();
    }

    public static void getMinOperations(int target, HashMap<Integer,Integer> output,int curr_level, ArrayList<Integer> workingnumber,int o, int signs[]){
        if(workingnumber.size()==0){
            return;
        }

        for(int i=0;i<workingnumber.size();i++){
            int curr_ele = workingnumber.get(i);
            workingnumber.remove(i);

            HashMap<Integer,Integer> new_output = new HashMap<>();
            new_output.put(curr_ele,1);
            for(Map.Entry<Integer,Integer> entry:output.entrySet()){
                int val = entry.getKey();
                int level = entry.getValue();
                if(signs[0]==1){
                    int new_val = val+curr_ele;
                    int new_level = level + 3;
                    if(!new_output.containsKey(new_val)){
                        new_output.put(new_val, new_level);
                    }
                    else if(new_output.get(new_val) > new_level){
                        new_output.put(new_val, new_level);
                    }
                    if(new_val==target && new_level<=o){
                        ans = Math.min(ans,new_level);
                    }
                }
                if(signs[1]==1){
                    int new_val = Math.abs(val-curr_ele);
                    int new_level = level + 3;
                    if(!new_output.containsKey(new_val)){
                        new_output.put(new_val, new_level);
                    }
                    else if(new_output.get(new_val) > new_level){
                        new_output.put(new_val, new_level);
                    }
                    if(new_val==target && new_level<=o){
                        ans = Math.min(ans,new_level);
                    }
                }
                if(signs[2]==1){
                    int new_val = val*curr_ele;
                    int new_level = level + 3;
                    if(!new_output.containsKey(new_val)){
                        new_output.put(new_val, new_level);
                    }
                    else if(new_output.get(new_val) > new_level){
                        new_output.put(new_val, new_level);
                    }
                    if(new_val==target && new_level<=o){
                        ans = Math.min(ans,new_level);
                    }
                }
                if(signs[3]==1){
                    if(val!=0 && curr_ele>=val){
                        if(curr_ele%val==0){
                            int new_val = curr_ele/val;
                            int new_level = level + 3;
                            if(!new_output.containsKey(new_val)){
                                new_output.put(new_val, new_level);
                            }
                            else if(new_output.get(new_val) > new_level){
                                new_output.put(new_val, new_level);
                            }
                            if(new_val==target && new_level<=o){
                                ans = Math.min(ans,new_level);
                            }
                        }
                    }
                    else{
                        if(curr_ele!=0  && val%curr_ele==0){
                            int new_val = val/curr_ele;
                            int new_level = level + 3;
                            if(!new_output.containsKey(new_val)){
                                new_output.put(new_val, new_level);
                            }
                            else if(new_output.get(new_val) > new_level){
                                new_output.put(new_val, new_level);
                            }
                            if(new_val==target && new_level<=o){
                                ans = Math.min(ans,new_level);
                            }
                        }
                    }
                }
                String one = Integer.toString(curr_ele);
                String two = Integer.toString(val);

                int new_val = Integer.parseInt(one.concat(two));
                int new_level = level+1;
                if(!new_output.containsKey(new_val)){
                    new_output.put(new_val, new_level);
                }
                else if(new_output.get(new_val) > new_level){
                    new_output.put(new_val, new_level);
                }
                if(new_val==target && new_level<=o){
                    ans = Math.min(ans,new_level);
                }

                new_val = Integer.parseInt(two.concat(one));
                if(!new_output.containsKey(new_val)){
                    new_output.put(new_val, new_level);
                }
                else if(new_output.get(new_val) > new_level){
                    new_output.put(new_val, new_level);
                }
                if(new_val==target && new_level<=o){
                    ans = Math.min(ans,new_level);
                }
            }

            for(Map.Entry<Integer,Integer> entry:output.entrySet()){
                int val = entry.getKey();
                int new_Freq = entry.getValue();

                if(!new_output.containsKey(val)){
                    new_output.put(val, new_Freq);
                }
                else{
                    if(new_output.get(val)>new_Freq){
                        new_output.put(val, new_Freq);
                    }
                }
            }
            getMinOperations(target, new_output, curr_level+1, workingnumber, o, signs);
            workingnumber.add(i, curr_ele);
        }
    }
}