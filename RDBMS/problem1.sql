#1.	How many copies of the book titled The Lost Tribe are owned by the library branch whose name is "Sharpstown"?
select noOfCopies
from tbl_book, tbl_book_copies, tbl_library_branch
where tbl_book.title = 'The Lost Tribe' and tbl_library_branch.branchName = 'Sharpstown';