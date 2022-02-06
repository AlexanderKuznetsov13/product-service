package ru.alex.kuznetsov.project.product.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.UserTypeRequestDto;
import ru.alex.kuznetsov.project.product.dto.UserTypeResponseDto;
import ru.alex.kuznetsov.project.product.entity.UserTypeEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.UserTypeRepository;
import ru.alex.kuznetsov.project.product.service.IUserTypeService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTypeServiceImpl implements IUserTypeService {

    private final Logger logger = LoggerFactory.getLogger(UserTypeServiceImpl.class);


    private final UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserTypeResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get userType with %d", id));
        userTypeRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("UserType with ID = %d not found", id)));
        return CommonMapper.fromUserTypeEntityToUserTypeResponseDto(userTypeRepository.getById(id));
    }

    @Override
    public UserTypeResponseDto create(UserTypeRequestDto requestDto){
        logger.debug(String.format("create - create userType"));
        UserTypeEntity userType = CommonMapper.fromUserTypeRequestDtoToUserTypeEntity(requestDto);
        return CommonMapper.fromUserTypeEntityToUserTypeResponseDto(userTypeRepository.save(userType));
    }

    @Override
    public UserTypeResponseDto update(UserTypeRequestDto requestDto) {
        UserTypeEntity userType = CommonMapper.fromUserTypeRequestDtoToUserTypeEntity(requestDto);
        logger.debug(String.format("update - update userType with %d", userType.getId()));
        return CommonMapper.fromUserTypeEntityToUserTypeResponseDto(userTypeRepository.save(userType));
    }

    @Override
    public List<UserTypeResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all userType"));
        return userTypeRepository.findAll().stream().map(CommonMapper::fromUserTypeEntityToUserTypeResponseDto).collect(Collectors.toList());
    }


    @Override
    public void deleteById(Integer id) {
        userTypeRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - UserType with ID = %d not found", id));
            return new NoEntityException(String.format("UserType with ID = %d not found", id));
        });
        userTypeRepository.deleteById(id);
    }
}
