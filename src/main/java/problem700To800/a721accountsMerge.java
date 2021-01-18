package problem700To800;

import java.util.*;
import java.util.stream.Collectors;


// 并查集，想到了，但是不知道怎么写，直接照着题意暴力解决，不过并查集34ms，暴力800ms。。。
public class a721accountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mailToUser = new HashMap<>();
        Map<Integer, Set<String>> userToMail = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            Set<Integer> user = new HashSet<>();
            Set<String> mail = new HashSet<>();
            for (int j = 1; j < account.size(); j++) {
                mail.add(account.get(j));
                if (mailToUser.containsKey(account.get(j))) {
                    user.add(mailToUser.get(account.get(j)));
                }
            }
            for (int u : user) {
                mail.addAll(userToMail.get(u));
                userToMail.remove(u);
            }
            for (String m : mail) {
                mailToUser.put(m, i);
                userToMail.computeIfAbsent(i, (key) -> new HashSet<>()).add(m);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i : userToMail.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(userToMail.get(i).stream().sorted().collect(Collectors.toList()));
            res.add(temp);
        }
        return res;
    }

    public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}

