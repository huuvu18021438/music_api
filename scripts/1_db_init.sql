CREATE DATABASE music_app;
DROP DATABASE IF EXISTS music_app;
ALTER DATABASE kxnfimxh RENAME TO music_app;

ALTER TABLE songs ALTER COLUMN meta_data SET NOT NULL
ALTER TABLE songs ALTER COLUMN image DROP NOT NULL;


-- pgcli 'postgres://huuvu18021438:RI4DftsnP5Vj@ep-curly-violet-380560.ap-southeast-1.aws.neon.tech/music_app'

--connect ElephanSQL
--pgcli postgres://kxnfimxh:IpEdUSWfVcXbLpoWpeNmuLEd02AxtQkN@tiny.db.elephantsql.com/kxnfimxh

