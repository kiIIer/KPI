CREATE SCHEMA news;

CREATE TABLE news.titles (
	id STRING NOT NULL,
	title STRING NOT NULL,
	date_created INT8 NOT NULL,
	rowid INT8 NOT VISIBLE NOT NULL DEFAULT unique_rowid(),
	CONSTRAINT "primary" PRIMARY KEY (rowid ASC),
	UNIQUE INDEX titles_id_idx (id ASC),
	FAMILY "primary" (id, title, datecreated, rowid)
);

CREATE TABLE news.articles (
	id STRING NOT NULL,
	article STRING NOT NULL,
	rowid INT8 NOT VISIBLE NOT NULL DEFAULT unique_rowid(),
	CONSTRAINT "primary" PRIMARY KEY (rowid ASC),
	CONSTRAINT articles_fk FOREIGN KEY (id) REFERENCES news.titles(id) ON DELETE CASCADE ON UPDATE RESTRICT,
	FAMILY "primary" (id, article, rowid)
);