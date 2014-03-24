extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE
 debut :
STARTUPCODE

;ouvrePrinc
mov bp,sp
sub sp,10

;iConst
push word ptr 2

;iConst
push word ptr 2

;iConst
push word ptr 3

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-10],ax

;iLoad
push word ptr [bp-10]

;ecrireEnt
call ecrent

;aLaLigne
call ligsuiv

;iConst
push word ptr 2

;iConst
push word ptr 2

;iConst
push word ptr 2

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 2

;iadd
pop bx
pop ax
add ax,bx
push ax

;imul
pop bx
pop ax
imul bx
push ax

;iadd
pop bx
pop ax
add ax,bx
push ax

;ecrireEnt
call ecrent

;queue
nop
EXITCODE
End debut
