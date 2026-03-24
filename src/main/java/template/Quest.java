package template;

public class Quest {
    public short id;
    public boolean isMain;
    public String name;
    public byte npcFrom;
    public String desc;
    public byte npcTo;
    public String detail;
    public short nextQuestId; // nhiệm vụ kế tiếp
    // quest target
    public byte type; // 0=talk to NPC, 1=kill mob
    public int mobId; // mob_id cần giết (-1 nếu không cần)
    public int killCount; // số lượng cần giết
    // reward
    public int rewardExp;
    public int rewardVang;
    public int rewardNgoc;

    public Quest(short id, boolean isMain, String name, byte npcFrom, String desc, byte npcTo, String detail, short nextQuestId) {
        this.id = id;
        this.isMain = isMain;
        this.name = name;
        this.npcFrom = npcFrom;
        this.desc = desc;
        this.npcTo = npcTo;
        this.detail = detail;
        this.nextQuestId = nextQuestId;
        this.type = 0;
        this.mobId = -1;
        this.killCount = 0;
        this.rewardExp = 0;
        this.rewardVang = 0;
        this.rewardNgoc = 0;
    }

    public Quest(short id, boolean isMain, String name, byte npcFrom, String desc, byte npcTo, String detail, short nextQuestId,
                 byte type, int mobId, int killCount, int rewardExp, int rewardVang, int rewardNgoc) {
        this(id, isMain, name, npcFrom, desc, npcTo, detail, nextQuestId);
        this.type = type;
        this.mobId = mobId;
        this.killCount = killCount;
        this.rewardExp = rewardExp;
        this.rewardVang = rewardVang;
        this.rewardNgoc = rewardNgoc;
    }
}
