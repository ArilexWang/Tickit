package com.example.ricardo.tickit.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.ricardo.tickit.data.dto.entity.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Password = new Property(1, String.class, "password", false, "PASSWORD");
        public final static Property UserName = new Property(2, String.class, "userName", false, "USER_NAME");
        public final static Property RealName = new Property(3, String.class, "realName", false, "REAL_NAME");
        public final static Property AvatarPath = new Property(4, String.class, "avatarPath", false, "AVATAR_PATH");
        public final static Property MobileNumber = new Property(5, long.class, "mobileNumber", false, "MOBILE_NUMBER");
        public final static Property Email = new Property(6, String.class, "email", false, "EMAIL");
        public final static Property IsSuperuser = new Property(7, Boolean.class, "isSuperuser", false, "IS_SUPERUSER");
        public final static Property Level = new Property(8, int.class, "level", false, "LEVEL");
        public final static Property Experience = new Property(9, int.class, "experience", false, "EXPERIENCE");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PASSWORD\" TEXT," + // 1: password
                "\"USER_NAME\" TEXT," + // 2: userName
                "\"REAL_NAME\" TEXT," + // 3: realName
                "\"AVATAR_PATH\" TEXT," + // 4: avatarPath
                "\"MOBILE_NUMBER\" INTEGER NOT NULL ," + // 5: mobileNumber
                "\"EMAIL\" TEXT," + // 6: email
                "\"IS_SUPERUSER\" INTEGER," + // 7: isSuperuser
                "\"LEVEL\" INTEGER NOT NULL ," + // 8: level
                "\"EXPERIENCE\" INTEGER NOT NULL );"); // 9: experience
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String realName = entity.getRealName();
        if (realName != null) {
            stmt.bindString(4, realName);
        }
 
        String avatarPath = entity.getAvatarPath();
        if (avatarPath != null) {
            stmt.bindString(5, avatarPath);
        }
        stmt.bindLong(6, entity.getMobileNumber());
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        Boolean isSuperuser = entity.getIsSuperuser();
        if (isSuperuser != null) {
            stmt.bindLong(8, isSuperuser ? 1L: 0L);
        }
        stmt.bindLong(9, entity.getLevel());
        stmt.bindLong(10, entity.getExperience());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(2, password);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(3, userName);
        }
 
        String realName = entity.getRealName();
        if (realName != null) {
            stmt.bindString(4, realName);
        }
 
        String avatarPath = entity.getAvatarPath();
        if (avatarPath != null) {
            stmt.bindString(5, avatarPath);
        }
        stmt.bindLong(6, entity.getMobileNumber());
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(7, email);
        }
 
        Boolean isSuperuser = entity.getIsSuperuser();
        if (isSuperuser != null) {
            stmt.bindLong(8, isSuperuser ? 1L: 0L);
        }
        stmt.bindLong(9, entity.getLevel());
        stmt.bindLong(10, entity.getExperience());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // password
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // realName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // avatarPath
            cursor.getLong(offset + 5), // mobileNumber
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // email
            cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // isSuperuser
            cursor.getInt(offset + 8), // level
            cursor.getInt(offset + 9) // experience
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPassword(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRealName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAvatarPath(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setMobileNumber(cursor.getLong(offset + 5));
        entity.setEmail(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setIsSuperuser(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setLevel(cursor.getInt(offset + 8));
        entity.setExperience(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
