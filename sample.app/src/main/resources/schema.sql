DROP TABLE IF EXISTS ConversationListTable;

CREATE TABLE ConversationListTable (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  source VARCHAR(250) NOT NULL,
  target VARCHAR(250) NOT NULL,
  sourceAmout double,
  targetAmout double,
);