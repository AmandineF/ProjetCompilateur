;entete
extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
.model SMALL
.586
.CODE

trace:
;ouvbloc 0
enter 0,0
;iLoad
push word ptr [bp+6]

;iLoad
push word ptr [bp+4]

;idiff
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iLoad
push word ptr [bp+4]

;iConst
push word ptr 25

;iLoad
push word ptr [bp+6]

;isub
pop bx
pop ax
sub ax,bx
push ax

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;iConst
push word ptr 0

;ecrireEnt
call ecrent

;goto FSI2
jmp FSI2

SINON2:
;iConst
push word ptr 1

;ecrireEnt
call ecrent

FSI2:

;goto FSI1
jmp FSI1

SINON1:
;iConst
push word ptr 0

;ecrireEnt
call ecrent

FSI1:

;iLoad
push word ptr [bp+6]

;iConst
push word ptr 24

;iegal
pop bx
pop ax
cmp ax,bx
jne $+6
push -1
jmp $+4
push 0

;iffaux SINON3
pop ax
cmp ax,0
je SINON3

;aLaLigne
call ligsuiv

;goto FSI3
jmp FSI3

SINON3:
FSI3:

;iConst
push word ptr -1

;ireturn 8
pop ax
mov [bp+8],ax

;fermebloc 4
leave
ret 4

debut :
STARTUPCODE

main:
;ouvbloc 6
enter 6,0
;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-2],ax

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-4],ax

FAIRE1:
;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 25

;idiff
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0

;iffaux FAIT1
pop ax
cmp ax,0
je FAIT1

;ecrireChaine
.DATA
mess0 DB "                    $"
.CODE
lea dx,mess0
push dx
call ecrch

FAIRE2:
;iLoad
push word ptr [bp-2]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iConst
push word ptr 25

;idiff
pop bx
pop ax
cmp ax,bx
je $+6
push -1
jmp $+4
push 0

;iffaux FAIT2
pop ax
cmp ax,0
je FAIT2

;reserveRetour
sub sp,2

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;call trace
call trace

;iStore
pop ax
mov word ptr [bp-6],ax

;iLoad
push word ptr [bp-2]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-2],ax

;goto FAIRE2
jmp FAIRE2

FAIT2:
;iLoad
push word ptr [bp-4]

;iConst
push word ptr 1

;iadd
pop bx
pop ax
add ax,bx
push ax

;iStore
pop ax
mov word ptr [bp-4],ax

;iConst
push word ptr 0

;iStore
pop ax
mov word ptr [bp-2],ax

;goto FAIRE1
jmp FAIRE1

FAIT1:
;queue
nop
EXITCODE
end