#2.	How many copies of the book titled The Lost Tribe are owned by each library branch?
select branchId, noOfCopies
from tbl_book, tbl_book_copies
where title='The Lost Tribe'
group by branchId