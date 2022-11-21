package smart.myhome.service;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HandleStat implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date begin = new Date();
    public String dataInfo;
    public int totalCount = 0;
    public int saved = 0;
    public int updated = 0;
    public int deleted = 0;
    public int links = 0;
    public int mappings = 0;
    public int noChanged = 0;
    public int unknownObjects = 0;
    public int unknownFields = 0;
    public int skipUpdates = 0;
    public int skipOld = 0;
    public int mappingsCreated = 0;
    public int mappingsUpdated = 0;
    public int notMapped = 0;
    public int errData = 0;
    public int errDb = 0;
    public int errMapping = 0;
    public int errValidation = 0;
    public int deletedBySync = 0;
    public int errOthers = 0;
    public int errDup = 0;
    public int warnData = 0;
    public int errReference= 0;
    public long totalStoreTime = 0;

    private int totalCounterErrors = 0;

    private int totalCounterChanges = 0;

    public Map<String, Integer> counter = new HashMap<>();

    public HandleStat() {
    }

    public HandleStat(HandleStat other) {
        addStat(other);
    }

    public void inc(final String key) {
        inc(key, 1);
    }

    public void inc(final String key, int incValue) {
        Integer prev = counter.get(key);
        counter.put(key, incValue + (prev == null ? 0 : prev));
    }

    public void incError(final String key) {
        incError(key, 1);
    }

    public void incError(final String key, int incValue) {
        inc(key, incValue);
        totalCounterErrors += incValue;
    }

    public void incChange(final String key) {
        incChange(key, 1);
    }

    public void incChange(final String key, int incValue) {
        inc(key, incValue);
        totalCounterChanges += incValue;
    }

    public String getProcStatus(final String dataInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(dataInfo);
        sb.append(" обработаны за ");
        sb.append(DateUtils.getPeriodInfo(begin));
        if (hasErrors()) {
            sb.append(" c ошибками:\n");
        } else {
            sb.append(" без ошибок:\n");
        }
        sb.append(this);
        return sb.toString();
    }

    public boolean hasChanges() {
        return saved > 0 || updated > 0 || deleted > 0 || deletedBySync > 0 || mappingsCreated > 0 || mappingsUpdated > 0 || totalCounterChanges > 0;
    }

    public boolean hasErrors() {
        return errData > 0 || errDb > 0 || errMapping > 0 || errOthers > 0 || errValidation > 0 || errDup > 0 || errReference > 0 || totalCounterErrors > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dataInfo != null) {
            sb.append(dataInfo + ": всего " + totalCount);
        } else {
            sb.append("Всего " + totalCount);
        }
        addNonZeroParam(sb, "сохранено в БД", saved);
        addNonZeroParam(sb, "обновлено в БД", updated);
        addNonZeroParam(sb, "удалено в БД", deleted);
        addNonZeroParam(sb, "обработано ссылок", links);
        addNonZeroParam(sb, "обработано соответствий", mappings);
        addNonZeroParam(sb, "пропущено не изменившихся в БД", noChanged);
        addNonZeroParam(sb, "пропущено обновлений по политике", skipUpdates);
        addNonZeroParam(sb, "пропущено старых", skipOld);
        addNonZeroParam(sb, "пропущено неизвестных объектов", unknownObjects);
        addNonZeroParam(sb, "пропущено неизвестных атрибутов", unknownFields);
        addNonZeroParam(sb, "создано соответствий(маппингов)", mappingsCreated);
        addNonZeroParam(sb, "обновлено соответствий(маппингов)", mappingsUpdated);
        addNonZeroParam(sb, "не замаплено", notMapped);
        addNonZeroParam(sb, "ошибок БД", errDb);
        addNonZeroParam(sb, "ошибок маппинга", errMapping);
        addNonZeroParam(sb, "ошибок в данных", errData);
        addNonZeroParam(sb, "ошибок валидации", errValidation);
        addNonZeroParam(sb, "прочих ошибок", errOthers);
        addNonZeroParam(sb, "дубликатов объектов", errDup);
        addNonZeroParam(sb, "предупреждений", warnData);
        addNonZeroParam(sb, "ошибок в связанных объектах", errReference);
        addNonZeroParam(sb, "время работы с хранилищем, мс.", (int) totalStoreTime);
        counter.forEach((k, v) -> {
            addNonZeroParam(sb, k, v);
        });
        return sb.toString();
    }

    private void addNonZeroParam(final StringBuilder sb, final String name, int value) {
        if (value > 0) {
            sb.append(", ");
            sb.append(name);
            sb.append(": ");
            sb.append(value);
        }
    }

    public void addStat(HandleStat stat) {
        totalCount += stat.totalCount;
        saved += stat.saved;
        updated += stat.updated;
        deleted += stat.deleted;
        links += stat.links;
        mappings += stat.mappings;
        noChanged += stat.noChanged;
        unknownFields += stat.unknownFields;
        unknownObjects += stat.unknownObjects;
        skipUpdates += stat.skipUpdates;
        skipOld += stat.skipOld;
        mappingsCreated += stat.mappingsCreated;
        mappingsUpdated += stat.mappingsUpdated;
        notMapped += stat.notMapped;
        errData += stat.errData;
        errDb += stat.errDb;
        errMapping += stat.errMapping;
        errValidation += stat.errValidation;
        deletedBySync += stat.deletedBySync;
        errOthers += stat.errOthers;
        errDup += stat.errDup;
        warnData += stat.warnData;
        errReference += stat.errReference;
        totalCounterErrors += stat.totalCounterErrors;
        totalCounterChanges += stat.totalCounterChanges;
        totalStoreTime += stat.totalStoreTime;
        for (Map.Entry<String, Integer> ce : stat.counter.entrySet()) {
            Integer integer = counter.get(ce.getKey());
            if (integer == null)
                counter.put(ce.getKey(), ce.getValue());
            else
                counter.put(ce.getKey(), integer + ce.getValue());
        }
    }
}
